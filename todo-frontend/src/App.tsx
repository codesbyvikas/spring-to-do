import { useEffect, useState } from 'react'
import './App.css'
import type { Todo } from './types/todo'

const API_URL = "http://localhost:8081/todos";

function App() {

  const [todos, setTodos] = useState<Todo[]>([]);
  const [title, setTitle] = useState<string>("");

  const fetchTodos = async(): Promise<void> => {
    const res = await fetch(API_URL);
    const data:Todo[] = await res.json();
    setTodos(data);
  };

  useEffect(() => {
    const fetchTodos = async (): Promise<void> => {
      const res = await fetch(API_URL);
      const data: Todo[] = await res.json();
      setTodos(data);
    }
    fetchTodos();
  }, []);

const addTodo = async (): Promise<void> => {
  if(!title.trim()) return;

  await fetch(API_URL, {
    method:"POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({
      title,
      completed:false,
    }),
  });
  setTitle("");
  fetchTodos();
}

const deleteTodo = async (id:number) : Promise<void> => {
  await fetch(`${API_URL}/${id}`, {
    method:"DELETE"
  });
  fetchTodos();
};


  return (
   <div className='container'>
    <h1>Todo App</h1>
    <div className='input-box'>
      <input type="text"
      placeholder='Enter todo'
      value={title}
      onChange={(e)=>{
        setTitle(e.target.value)
      }} />
      <button onClick={addTodo}>Add</button>
    </div>
    <ul>
      {todos.map((todo)=> {
       return <li key={todo.id}>
          {todo.title}
          <button onClick={()=> deleteTodo(todo.id)}>❌</button>
        </li>
      })}
    </ul>
   </div>
  );
}

export default App
