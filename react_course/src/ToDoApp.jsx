import React, {useState} from "react";

function ToDoApp(){

    const [tasks,setTasks] = useState(["Eat Breakfast", "Take a shower", "Walk the dog"]);
    const [newTask, setNewTask] = useState("");

    function handleInputChangle(e){
        setNewTask(e.target.value);
    }

    function addTasks(){
        if(newTask.trim() !== ""){
            setTasks(t => [...t, newTask]);
            setNewTask("");
        }
    }

    function deleteTask(index){
        const updatedTasks = tasks.filter((_,i) => index !== i)
        setTasks(updatedTasks);
    }

    function moveTaskUp(index){
        if(index > 0){
            const updatedTasks = [...tasks];
            [updatedTasks[index], updatedTasks[index-1]] = [updatedTasks[index-1], updatedTasks[index]]
            setTasks(updatedTasks);
        }
    }

    function moveTaskDown(index){
        if(index < tasks.length -1 ){
            const updatedTasks = [...tasks];
            [updatedTasks[index], updatedTasks[index+1]] = [updatedTasks[index+1], updatedTasks[index]]
            setTasks(updatedTasks);
        }
    }

    return (
        <div className="to-do-list">
            <h1>To-Do-List</h1>
            <div>
                <input
                type="text"
                placeholder="Enter a task..."
                value={newTask}
                onChange={handleInputChangle}
                />
                <button
                className="add-button"
                onClick={addTasks}>
                Add
                </button>
            </div>

            <ol>
                {tasks.map((task,index) =>
                    <li key={index}>
                        <span className="text">{task}</span>
                        <button 
                        className="delete-button"
                        onClick={() => deleteTask(index)}>
                            Delete
                        </button>
                        <button 
                        className="move-button"
                        onClick={() => moveTaskUp(index)}>
                            👆
                        </button>
                        <button 
                        className="move-button"
                        onClick={() => moveTaskDown(index)}>
                            👇
                        </button>
                    </li>
                )}
            </ol>
        </div>
    );
}

export default ToDoApp;