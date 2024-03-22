import React, { useState, useEffect } from "react";
import { useDataContext } from "../../contexts/ArticleContext";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import "./component.css";
import { toast } from "react-toastify";

const BlogDetail = () => {
  const navigate = useNavigate();
  const {
    data,
    clearSelectedArticle,
    deleteData,
    likeData,
    dislikeData,
    likedBlogs,
  } = useDataContext();
  const { id } = useParams();
  const article = data.find((article) => article.id === parseInt(id));

  const [liked, setLiked] = useState(false);

  useEffect(() => {
    // Check if the blog ID exists in the 'likedBlogs' array
    const isLiked = likedBlogs.some((blog) => blog.id === parseInt(id));
    setLiked(isLiked);
  }, [likedBlogs, id]);

  const handleEdit = () => {
    navigate(`/blog/${id}/edit`);
  };

  const handleDelete = () => {
    deleteData(parseInt(id));
    toast.success("Blog deleted successfully", {
      position: "top-right",
      autoClose: 2000,
      hideProgressBar: true,
      style: {
        backgroundColor: "red",
        color: "white",
      },
    });
    clearSelectedArticle();
  };

  const handleLike = () => {
    if (!liked) {
      likeData(parseInt(id));
      setLiked(true);
    } else {
      dislikeData(parseInt(id));
      setLiked(false);
    }
  };

  if (!article) {
    return <p>Article not found</p>;
  }

  return (
    <div className="blog-detail-container">
      <button
        className="back-button top-0 float-start m-2"
        onClick={clearSelectedArticle}
      >
        Back to List
      </button>

      <div className="blog-detail container d-flex flex-column align-items-center justify-content-center text-center w-50">
        <div className="blog-content mt-5">
          <h2>{article.title}</h2>
          <p>Category: {article.category}</p>
          <p>{article.description}</p>
          <p>{article.content}</p>
          <p>Author: {article.author}</p>
        </div>
        <div className="m-2 action-buttons">
          <button className="m-2 edit-button" onClick={handleEdit}>
            Edit
          </button>
          <button className="m-2 delete-button" onClick={handleDelete}>
            Delete
          </button>
          <button className="m-2 like-button" onClick={handleLike}>
            {liked ? (
              <span>
                <i className="fas fa-heart text-danger"></i> {article.likes}
              </span>
            ) : (
              <span>
                <i className="far fa-heart"></i> {article.likes}
              </span>
            )}
          </button>
        </div>
      </div>
    </div>
  );
};

export default BlogDetail;
