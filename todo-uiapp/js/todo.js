
const baseUrl = 'http://localhost:8081/api/v1/task';

const idTodoTable = document.getElementById('idTodoTable');
const getTasks = async () => {
    const response = await fetch(baseUrl+'/all');
    const data = await response.json();
    return data;
}
const getArchivedTasks = async () => {
    const response = await fetch(baseUrl+'/all-archived');
    const data = await response.json();
    return data;
}

function showTasks(f) {
    f().then((tasks) => {
        idTodoTable.innerHTML = '';
        let tableContent = '';
        tableContent +='<table class="table table-striped table-bordered table-hover">';
        tableContent +='<thead>';
        tableContent +='<tr>';
        tableContent +='<th scope="col">Title</th>';
        tableContent +='<th scope="col">Description</th>';
        tableContent +='<th scope="col">Due Date</th>';
        tableContent +='<th scope="col">Status</th>';
        tableContent +='<th scope="col">Actions</th>';
        tableContent +='</tr>';
        tableContent +='</thead>';
        tableContent +='<tbody>';
        
        if (tasks.length === 0) {
            tableContent += '<tr>';
            tableContent += '<td colspan="5" class="text-center">No tasks available</td>';
            tableContent += '</tr>';
        }
    

        tasks.forEach(task => {
            let taskStr = JSON.stringify(task);
            console.log(`${taskStr}`);
            tableContent += '<tr>';
            tableContent += `<td>${task.title}</td>`;
            tableContent += `<td>${task.description}</td>`;
            tableContent += `<td>${task.dueDate}</td>`;
            tableContent += `<td>${task.status}</td>`;
            tableContent += `<td>
                <select class="form-select" id=${task.id} aria-label="Change Status" onchange="updateTaskStatus('${task.id}','${task.status}')">
                    <option value=''>Change Status</option>
                    <option value="PENDING">PENDING</option>
                    <option value="IN_PROGRESS">IN_PROGRESS</option>
                    <option value="COMPLETED">COMPLETED</option>
                    <option value="ARCHIVED">ARCHIVED</option>
                </select>

            </td>`;
            tableContent += '</tr>';
        });
        tableContent += '</tbody>';
        tableContent += '</table>';
        idTodoTable.innerHTML = tableContent;  
        });
}

function updateTaskStatus(id,currentStatus) {
    const idStatus = document.getElementById(id);
    let status = idStatus.value;
    if (status === '') {
        return;
    }
    if(currentStatus === status) {
        return;
    }
    const url = baseUrl + '/update-status/' + id+ '/' + status;
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (response.ok) {
            showTasks(getTasks);
        } else {
            alert('Error updating task status');
        }
    }
    ).catch(error => {
        alert('Error:', error);
    });
}

const idShowArchived  = document.getElementById('idShowArchived');

idShowArchived.addEventListener('click', function() {
        showTasks(getArchivedTasks);
});


showTasks(getTasks);

