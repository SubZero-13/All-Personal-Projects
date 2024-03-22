export const editBlog = (id, updatedBlog) => ({
  type: 'EDIT_BLOG',
  payload: { id, updatedBlog },
});

export const deleteBlog = (id) => ({
  type: 'DELETE_BLOG',
  payload: id,
});

export const likeBlog = (id) => ({
  type: 'LIKE_BLOG',
  payload: id,
});

export const addBlog = (newBlog) => ({
  type: 'ADD_BLOG',
  payload: newBlog,
});

export const dislikeBlog = (id) => {
  return {
    type: "DISLIKE_BLOG",
    payload: id,
  };
};



