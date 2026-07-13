import "./App.css";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {
  const books = [
    {
      id: 101,
      bname: "Master React",
      price: 670,
    },
    {
      id: 102,
      bname: "Deep Dive into Angular 11",
      price: 800,
    },
    {
      id: 103,
      bname: "Mongo Essentials",
      price: 450,
    },
  ];

  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Stephen Biz",
      description: "Welcome to learning React!",
    },
    {
      id: 2,
      title: "Installation",
      author: "Schewzdenier",
      description: "You can install React from npm.",
    },
  ];

  const courses = [
    {
      id: 1,
      name: "Angular",
      date: "4/5/2021",
    },
    {
      id: 2,
      name: "React",
      date: "6/3/2021",
    },
  ];

  const showBookDetails = true;
  const showBlogDetails = true;
  const showCourseDetails = true;

  return (
    <div className="App">
      <div className="details-container">

        {showCourseDetails && (
          <div className="details-section">
            <CourseDetails courses={courses} />
          </div>
        )}

        {showBookDetails ? (
          <div className="details-section">
            <BookDetails books={books} />
          </div>
        ) : (
          <div className="details-section">
            <h1>Book Details</h1>
            <p>Book details are hidden.</p>
          </div>
        )}

        <div className="details-section last-section">
          {showBlogDetails
            ? <BlogDetails blogs={blogs} />
            : null}
        </div>

      </div>
    </div>
  );
}

export default App;