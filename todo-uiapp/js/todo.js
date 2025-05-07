
const baseUrl = 'http://localhost:8081/api/v1/task';


const getTasks = async () => {
    const response = await fetch(baseUrl+'/all');
    const data = await response.json();
    return data;
}




function showTasks() {
    getTasks().then((tasks) => {
        console.log(tasks);
        const taskList = document.getElementById('task-list');
        taskList.innerHTML = '';
        tasks.forEach((task) => {
            const li = document.createElement('li');
            li.textContent = task.name;
            taskList.appendChild(li);
        });
    });
}


showTasks();

