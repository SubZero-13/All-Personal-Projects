import React, { createContext, useContext, useState, useEffect } from "react";
import { ArticleList } from "../config";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import {
  editBlog,
  deleteBlog,
  likeBlog,
  addBlog,
  dislikeBlog,
} from "../redux/actions/BlogActions";

const LOCAL_STORAGE_KEY = "blogAppData";

const ArticleContext = createContext();

export function useDataContext() {
  return useContext(ArticleContext);
}

export function DataProvider({ children }) {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const initialData =
    JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY)) || ArticleList;
  const initialLikedBlogs =
    JSON.parse(localStorage.getItem("LikedBlogs")) || [];
  const [data, setData] = useState(initialData);
  const [likedBlogs, setLikedBlogs] = useState(initialLikedBlogs);

  // Redux state
  const blogs = useSelector((state) => state.blogs);

  // Save data to local storage whenever it changes
  useEffect(() => {
    localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(data));
  }, [data]);

  useEffect(() => {
    localStorage.setItem("LikedBlogs", JSON.stringify(likedBlogs));
  }, [likedBlogs]);

  const addData = (newData) => {
    setData((prevData) => [...prevData, newData]);
    dispatch(addBlog(newData));
  };

  const editData = (id, updatedData) => {
    // Find the index of the article in the context data
    const dataIndex = data.findIndex((item) => item.id === id);

    // Update the context data
    if (dataIndex !== -1) {
      const newData = [...data];
      newData[dataIndex] = { ...newData[dataIndex], ...updatedData };
      setData(newData);
    }

    // Dispatch action to update Redux state
    dispatch(editBlog(id, updatedData));
  };

  const deleteData = (id) => {
    // Remove the article from the context data
    const newData = data.filter((item) => item.id !== id);
    setData(newData);

    // Dispatch action to update Redux state
    dispatch(deleteBlog(id));
  };

  const likeData = (id) => {
    const dataIndex = data.findIndex((item) => item.id === id);

    // Update the context data
    if (dataIndex !== -1) {
      const newData = data.map((item, index) => {
        if (index === dataIndex) {
          return {
            ...item,
            likes: item.likes + 1,
          };
        }
        return item;
      });

      setData(newData);

      // Add the liked blog to the likedBlogs state
      setLikedBlogs((prevLikedBlogs) => [
        ...prevLikedBlogs,
        newData[dataIndex],
      ]);
    }

    // Dispatch action to update Redux state
    dispatch(likeBlog(parseInt(id)));
  };

  const dislikeData = (id) => {
    const dataIndex = data.findIndex((item) => item.id === id);

    // Update the context data and likedBlogs
    if (dataIndex !== -1) {
      const newData = data.map((item, index) => {
        if (index === dataIndex) {
          return {
            ...item,
            likes: item.likes - 1,
          };
        }
        return item;
      });

      setData(newData);

      // Remove the disliked blog from the likedBlogs state
      setLikedBlogs((prevLikedBlogs) =>
        prevLikedBlogs.filter((blog) => blog.id !== id)
      );
    }

    // Dispatch action to update Redux state
    dispatch(dislikeBlog(parseInt(id)));
  };

  const clearSelectedArticle = () => {
    navigate("/");
  };

  return (
    <ArticleContext.Provider
      value={{
        data,
        blogs,
        addData,
        editData,
        deleteData,
        likeData,
        dislikeData,
        clearSelectedArticle,
        likedBlogs,
      }}
    >
      {children}
    </ArticleContext.Provider>
  );
}
