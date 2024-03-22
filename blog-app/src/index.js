import React from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App";
import { DataProvider } from "../src/contexts/ArticleContext";
import { Provider } from "react-redux";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { configureStore } from "@reduxjs/toolkit";
import rootReducer from "../src/redux/BlogReducer";
import Body from "./components/blogApp/layout/Body";
import BlogDetail from "./components/blogApp/BlogDetail";
import AddBlog from "./components/blogApp/AddBlog";
import EditBlog from "./components/blogApp/EditBlog";

const store = configureStore({
  reducer: rootReducer,
});

const root = createRoot(document.getElementById("root"));

const appRouter = createBrowserRouter([
  {
    path: "/",
    element: (
      <Provider store={store}>
        <DataProvider>
          <App />
        </DataProvider>
      </Provider>
    ),
    children: [
      {
        path: "/",
        element: <Body />,
      },
      {
        path: "/blog/:id",
        element: <BlogDetail />,
      },
      {
        path: "/add-blog",
        element: <AddBlog />,
      },

      {
        path: "/blog/:id/edit",
        element: <EditBlog />,
      },
    ],
  },
]);

root.render(<RouterProvider router={appRouter} />);
