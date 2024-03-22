import React, { useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { useDataContext } from "../../contexts/ArticleContext";
import { useSelector } from "react-redux";
import { toast } from "react-toastify";

const EditBlog = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const { editData } = useDataContext();

  const blogData = useSelector((state) => state.blogs);
  const blog = blogData.find((item) => item.id === parseInt(id)) || {};

  const [formData, setFormData] = useState({
    title: blog.title || "",
    category: blog.category || "",
    description: blog.description || "",
    content: blog.content || "",
    author: blog.author || "",
  });

  const [error, setError] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validation logic (you can add more validation as needed)
    if (
      !formData.title ||
      !formData.category ||
      !formData.description ||
      !formData.content ||
      !formData.author
    ) {
      setError("All fields are required");
      return;
    }

    if (formData.title.split(' ').length > 20) {
      setError("Title should not be more than 20 words");
      return;
    }
  
    if (formData.category.split(' ').length > 5) {
      setError("Category should not be more than 5 words");
      return;
    }

    // Update the blog data using the context API function
    editData(parseInt(id), formData);

    toast.success("Blog edited successfully", {
      position: "top-right",
      autoClose: 2000, 
      hideProgressBar: true,
    });

    // Redirect to the BlogDetail page upon successful edit
    navigate(`/blog/${id}`);
  };

  return (
    <div className="container form-container d-flex">
      <h3 className="form-heading">Edit Article</h3>
      {error && <p className="text-danger error">{error}</p>}
      <form onSubmit={handleSubmit} className="form">
        <div className="form-group">
          <label>Title:</label>
          <input
            type="text"
            name="title"
            value={formData.title}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Category:</label>
          <input
            name="category"
            value={formData.category}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Description:</label>
          <input
            name="description"
            value={formData.description}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="content">Content:</label>
          <textarea
            name="content"
            value={formData.content}
            onChange={handleChange}
            className="form-control text-area"
          />
        </div>
        <div className="form-group">
          <label>Author Name:</label>
          <input
            type="text"
            name="author"
            value={formData.author}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <button type="submit" className="edit-blog-button">
          Submit
        </button>
      </form>
    </div>
  );
};

export default EditBlog;

