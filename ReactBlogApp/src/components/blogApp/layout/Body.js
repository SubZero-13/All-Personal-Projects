import React from 'react';
import { Link } from 'react-router-dom';
import { useDataContext } from '../../../contexts/ArticleContext';
import BlogCard from './BlogCard';

const Body = () => {
  const { data } = useDataContext();
  return (
    <div className="body d-flex flex-row justify-content-around flex-wrap">
      {data.map((article, index) => (
        <Link to={`/blog/${article.id}`} key={article.id} className='link'>
          <BlogCard article={article} />
        </Link>
      ))}
    </div>
  );
};

export default Body;

