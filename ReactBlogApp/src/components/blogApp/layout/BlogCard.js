import React from "react";
const BlogCard = ({ article }) => {
  const truncateString = (str, numWords) => {
    const words = str.split(" ");
    const truncatedWords = words.slice(0, numWords);
    return truncatedWords.join(" ");
  };
  return (
    <>
      <div className="card d-flex flex-column flex-wrap justify-content-between m-2">
      <div className="card-body">
        <h2 className="card-title text-break fs-4 text-justify fw-semibold">{truncateString(article.title, 8)}</h2>
        <p className="card-text text-break fs-6 text-justify">Category: {article.category}</p>
        <p className="card-text text-break fs-6 text-justify">{truncateString(article.description, 15)}</p>
      </div>
      </div>
    </>
  );
};

export default BlogCard;
