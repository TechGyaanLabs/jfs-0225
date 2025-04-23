function showAlert() {
    alert("Hello, this is an alert!");
}

function showDateTime() {
    const idShowDateTime = document.querySelector("#idShowDateTime");
    const date = new Date();
    idShowDateTime.innerHTML = `<strong>${date.toLocaleString()}</strong>`;
}

function showResult(operator) {
    const num1 = parseFloat(document.getElementById("num1").value);
    const num2 = parseFloat(document.getElementById("num2").value);
    const result = document.getElementById("result");
    
    if (isNaN(num1) || isNaN(num2)) {
        result.value = "Please enter valid numbers";
        return;
    }

    const operations = {
        '+': (a, b) => `${a} + ${b} = ${a + b}`,
        '-': (a, b) => `${a} - ${b} = ${a - b}`,
        '*': (a, b) => `${a} * ${b} = ${a * b}`,
        '/': (a, b) => b === 0 ? "Error: Division by zero" : `${a} / ${b} = ${a / b}`,
        '%': (a, b) => `${a} % ${b} = ${a % b}`,
        '**': (a, b) => `${a} ** ${b} = ${a ** b}`
    };

    result.value = operations[operator]?.(num1, num2) || "Invalid operator";
}

// Initialize date time on page load
showDateTime();
