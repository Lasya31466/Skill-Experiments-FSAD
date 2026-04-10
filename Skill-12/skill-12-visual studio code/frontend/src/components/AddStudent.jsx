import { useState, useEffect } from "react";
import API from "../api";

const AddStudent = ({ fetchStudents, selected, setSelected }) => {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (selected) {
      setStudent(selected);
    }
  }, [selected]);

  const handleChange = (e) => {
    setStudent({
      ...student,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      if (selected) {
        await API.put(`/students/${selected.id}`, student);
      } else {
        await API.post("/students", student);
      }

      setStudent({ name: "", email: "", course: "" });
      setSelected(null);
      fetchStudents();

    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div>
      <h2>{selected ? "Update Student" : "Add Student"}</h2>

      <form onSubmit={handleSubmit}>
        <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
        <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
        <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />

        <button type="submit">
          {selected ? "Update" : "Add"}
        </button>
      </form>
    </div>
  );
};

export default AddStudent;