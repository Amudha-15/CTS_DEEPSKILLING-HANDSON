import React from "react";

function CourseDetails() {

  const courses = [
    "Java Full Stack",
    "Python",
    "React JS",
    "Machine Learning"
  ];

  return (
    <div>

      <h2>Course Details</h2>

      <ol
        style={{
          listStylePosition: "inside",
          padding: 0
        }}
      >

        {courses.map((course, index) => (

          <li key={index}>
            {course}
          </li>

        ))}

      </ol>

    </div>
  );
}

export default CourseDetails;