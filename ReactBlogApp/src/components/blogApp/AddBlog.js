import React, { useState } from "react";
import { useDataContext } from "../../contexts/ArticleContext";
import { toast } from "react-toastify";

const AddBlog = () => {
  const { addData } = useDataContext();
  const [formData, setFormData] = useState({
    title: "",
    description: "",
    content: "",
    author: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const id = Date.now();

    const blogData = { ...formData, likes: 0, id };

    // Add the new blog using the context API function
    addData(blogData);
    
    toast.success("Blog Added successfully", {
      position: "top-right",
      autoClose: 2000, 
      hideProgressBar: true,
    });

    // Reset the form
    setFormData({
      title: "",
      category: "",
      description: "",
      content: "",
      author: "",
    });
  };

  return (
    <div className="container form-container d-flex">
      <h3 className="form-heading">Add Article</h3>
      <form onSubmit={handleSubmit} className="form">
        <div className="form-group">
          <label htmlFor="title">Title</label>
          <input
            type="text"
            className="form-control"
            name="title"
            value={formData.title}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="category">Category</label>
          <input
            type="text"
            className="form-control"
            name="category"
            value={formData.category}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="description">Description</label>
          <input
            type="text"
            className="form-control"
            name="description"
            value={formData.description}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="content">Content</label>
          <textarea
            className="form-control text-area"
            name="content"
            value={formData.content}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="author">Author</label>
          <input
            type="text"
            className="form-control"
            name="author"
            value={formData.author}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="add-btn">Add</button>
      </form>
    </div>
  );
};

export default AddBlog;
