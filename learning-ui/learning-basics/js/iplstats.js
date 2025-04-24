// Load players.json data 

google.charts.load('current', {'packages':['corechart']});


async function loadPlayers() {
    try {
        const response = await fetch("data/players.json");
        return await response.json();
    } catch (error) {
        console.error("Error loading players:", error);
        return [];
    }
}

async function showTeamAmountStats() {
    const players = await loadPlayers();
    const teamAmount = players.reduce((acc, player) => {
        acc[player.team] = (acc[player.team] || 0) + player.amount;
        return acc;
    }, {});
    
    console.log(teamAmount);
    data = [['Team', 'Amount']];
    for (const [team, amount] of Object.entries(teamAmount)) {
        data.push([team, amount]);
    }
    google.charts.setOnLoadCallback(drawChart(data));
}
showTeamAmountStats();


function drawChart(chartData) {
    var data = google.visualization.arrayToDataTable(chartData);
    var options = {
      title: 'Team Amount Stats',
    };
    var chart = new google.visualization.ColumnChart(document.getElementById('teamAmountChart'));
    chart.draw(data, options);
  }
