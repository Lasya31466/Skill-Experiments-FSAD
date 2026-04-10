import { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {
  const [selected, setSelected] = useState(null);
  const [refresh, setRefresh] = useState(false);

  const fetchStudents = () => {
    setRefresh(!refresh);
  };

  return (
    <div>
      <h1>Student Management System</h1>

      <AddStudent
        fetchStudents={fetchStudents}
        selected={selected}
        setSelected={setSelected}
      />

      <StudentList
        setSelected={setSelected}
        refresh={refresh}
      />
    </div>
  );
}

export default App;