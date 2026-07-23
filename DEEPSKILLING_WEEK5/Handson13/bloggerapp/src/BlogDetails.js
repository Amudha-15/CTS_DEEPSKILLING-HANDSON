import React from "react";

function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "React Components",
      author: "John"
    },
    {
      id: 2,
      title: "Understanding JSX",
      author: "Alice"
    },
    {
      id: 3,
      title: "React Hooks",
      author: "David"
    }
  ];

  return (
    <div>

      <h2>Blog Details</h2>

      <ul
        style={{
          listStylePosition: "inside",
          padding: 0
        }}
      >

        {blogs.map((blog) => (

          <li key={blog.id}>
            <b>{blog.title}</b> - {blog.author}
          </li>

        ))}

      </ul>

    </div>
  );
}

export default BlogDetails;