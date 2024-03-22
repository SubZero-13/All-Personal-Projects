// BlogContext.js
import React, { createContext, useContext, useReducer } from "react";
import {ArticleList} from '../config'
const BlogContext = createContext();

export const useBlog = () => {
  return useContext(BlogContext);
};

const initialState = {
  articles: ArticleList,
};

const blogReducer = (state, action) => {
  switch (action.type) {
    case "ADD_ARTICLE":
      return {
        ...state,
        articles: [...state.articles, action.payload],
      };
    default:
      return state;
  }
};

export const BlogProvider = ({ children }) => {
  const [state, dispatch] = useReducer(blogReducer, initialState);

  return (
    <BlogContext.Provider value={{ state, dispatch }}>
      {children}
    </BlogContext.Provider>
  );
};
