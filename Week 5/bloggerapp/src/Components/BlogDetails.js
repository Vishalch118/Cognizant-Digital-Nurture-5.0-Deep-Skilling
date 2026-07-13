function BlogDetails({ blogs }) {
  const blogContent = blogs.map((blog) => (
    <div key={blog.id}>
      <h2>{blog.title}</h2>
      <h4>{blog.author}</h4>
      <p>{blog.description}</p>
    </div>
  ));

  return (
    <div>
      <h1>Blog Details</h1>

      {blogs.length > 0
        ? blogContent
        : <p>No blogs are available.</p>}
    </div>
  );
}

export default BlogDetails;