import { ArticleList } from "../config";
const initialState = {
  blogs: JSON.parse(localStorage.getItem("blogAppData")) || ArticleList,
};

const blogReducer = (state = initialState, action) => {
  switch (action.type) {
    case "EDIT_BLOG":
      const editedBlogs = state.blogs.map((blog) =>
        blog.id === action.payload.id ? action.payload.updatedBlog : blog
      );
      return { blogs: editedBlogs };

    case "DELETE_BLOG":
      const filteredBlogs = state.blogs.filter(
        (blog) => blog.id !== action.payload
      );
      return { blogs: filteredBlogs };

    
    case "LIKE_BLOG":
      const likedBlogIndex = state.blogs.findIndex(
        (blog) => blog.id === action.payload
      );
      if (likedBlogIndex !== -1) {
        const updatedBlog = {
          ...state.blogs[likedBlogIndex],
          likes: state.blogs[likedBlogIndex].likes + 1,
        };
        const updatedBlogs = [...state.blogs];
        updatedBlogs[likedBlogIndex] = updatedBlog;
        return { ...state, blogs: updatedBlogs };
      }
      return state; 

    case "DISLIKE_BLOG":
      const dislikedBlogIndex = state.blogs.findIndex(
        (blog) => blog.id === action.payload
      );
      if (dislikedBlogIndex !== -1) {
        const updatedBlog = {
          ...state.blogs[dislikedBlogIndex],
          likes: state.blogs[dislikedBlogIndex].likes - 1,
        };
        const updatedBlogs = [...state.blogs];
        updatedBlogs[dislikedBlogIndex] = updatedBlog;

        return { ...state, blogs: updatedBlogs };
      }
      return state; 

    case "ADD_BLOG":
      return {
        ...state,
        blogs: [...state.blogs, action.payload],
      };

    default:
      return state;
  }
};

export default blogReducer;
