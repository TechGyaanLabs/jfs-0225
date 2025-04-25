// Load Google Charts
google.charts.load('current', {'packages':['corechart']});

// Constants
const CHART_TYPES = {
    COLUMN: 'ColumnChart',
    PIE: 'PieChart',
    BAR: 'BarChart'
};

const CHART_OPTIONS = {
    width: '100%',
    height: 400,
    legend: { position: 'bottom' },
    animation: { duration: 1000, easing: 'out' }
};

// Cache for players data
let playersCache = null;

// Data loading and processing
async function loadPlayers() {
    if (playersCache) 
        return playersCache;
    
    try {
        const response = await fetch("data/players.json");
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        playersCache = await response.json();
        return playersCache;
    } catch (error) {
        console.error("Error loading players:", error);
        return [];
    }
}

// Data aggregation functions
const aggregators = {
    teamAmounts: players => players.reduce((acc, player) => {
        acc[player.team] = (acc[player.team] || 0) + player.amount;
        return acc;
    }, {}),

    maxTeamAmounts: players => players.reduce((acc, player) => {
        if (!acc[player.team] || player.amount > acc[player.team].amount) {
            acc[player.team] = {
                amount: player.amount,
                player: player.name
            };
        }
        return acc;
    }, {}),

    roleCounts: players => players.reduce((acc, player) => {
        acc[player.role] = (acc[player.role] || 0) + 1;
        return acc;
    }, {})
};

// Chart utilities
const chartUtils = {
    prepareChartData: (data, columns) => {
        const chartData = [columns];
        for (const [key, value] of Object.entries(data)) {
            chartData.push([key, value]);
        }
        return chartData;
    },

    drawChart: (chartData, chartType, title, divElement) => {
        try {
            const data = google.visualization.arrayToDataTable(chartData);
            const options = { ...CHART_OPTIONS, title };
            const chart = new google.visualization[chartType](document.getElementById(divElement));
            chart.draw(data, options);
        } catch (error) {
            console.error(`Error drawing ${chartType}:`, error);
        }
    }
};

// Player utilities
const playerUtils = {
    findTopNMaxAmounts: (players, n) => {
        const sortedPlayers = [...players].sort((a, b) => b.amount - a.amount);
        return sortedPlayers.slice(0, n);
    },

    filterByTeam: (players, team) => {
        return team ? players.filter(player => player.team === team) : players;
    },

    sortByAmount: players => {
        return [...players].sort((a, b) => b.amount - a.amount);
    }
};

// UI Components
const uiComponents = {
    createTeamDropdown: teams => {
        const html = `
            <select class="form-select" id="teamSelect" onchange="showTeamPlayers(this.value)">
                <option value="">Select Team</option>
                ${teams.map(team => `<option value="${team}">${team}</option>`).join('')}
            </select>
        `;
        document.getElementById("selectTeam").innerHTML = html;
    },

    createPlayerTable: (players, divName) => {
        const table = document.getElementById(divName);
        if (!players.length) {
            table.innerHTML = "<p>No players found</p>";
            return;
        }

        const html = `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Team</th>
                        <th>Role</th>
                        <th>Country</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                    ${players.map(player => `
                        <tr>
                            <td>${player.name}</td>
                            <td>${player.team}</td>
                            <td>${player.role}</td>
                            <td>${player.country}</td>
                            <td>${player.amount}</td>
                        </tr>
                    `).join('')}
                </tbody>
            </table>
        `;
        table.innerHTML = html;
    }
};

// Main visualization functions
const visualizations = {
    showTeamAmountStats: async () => {
        const players = await loadPlayers();
        const teamAmounts = aggregators.teamAmounts(players);
        const chartData = chartUtils.prepareChartData(teamAmounts, ['Team', 'Amount']);
        chartUtils.drawChart(chartData, CHART_TYPES.COLUMN, 'Team Amount Stats', 'teamAmountChart');
    },

    showRoleCountStats: async () => {
        const players = await loadPlayers();
        const roleCounts = aggregators.roleCounts(players);
        const chartData = chartUtils.prepareChartData(roleCounts, ['Role', 'Count']);
        chartUtils.drawChart(chartData, CHART_TYPES.PIE, 'Role Distribution', 'roleCountChart');
    },

    teamMaxAmountStats: async () => {
        const players = await loadPlayers();
        const teamMaxAmounts = aggregators.maxTeamAmounts(players);
        const chartData = [['Team', 'Max Amount', { role: 'tooltip' }]];
        for (const [team, data] of Object.entries(teamMaxAmounts)) {
            chartData.push([team, data.amount, `${data.player}: ${data.amount}`]);
        }
        chartUtils.drawChart(chartData, CHART_TYPES.BAR, 'Max Amount of Each Team', 'teamMaxAmountChart');
    }
};

// Team management functions
const teamManagement = {
    showTeamNamesAsDropDown: async () => {
        const players = await loadPlayers();
        const teams = [...new Set(players.map(player => player.team))];
        uiComponents.createTeamDropdown(teams);
    }
};

// Make showTeamPlayers globally accessible
window.showTeamPlayers = async (team) => {
    if (!team) {
        document.getElementById("teamPlayers").innerHTML = "<p>Please select a team to see player details</p>";
        return;
    }
    const players = await loadPlayers();
    const teamPlayers = playerUtils.filterByTeam(players, team);
    const sortedPlayers = playerUtils.sortByAmount(teamPlayers);
    uiComponents.createPlayerTable(sortedPlayers, "teamPlayers");
};

// Initialize everything when Google Charts is loaded
google.charts.setOnLoadCallback(async () => {
    await visualizations.showTeamAmountStats();
    await visualizations.showRoleCountStats();
    await visualizations.teamMaxAmountStats();
    await teamManagement.showTeamNamesAsDropDown();
    
    // Show top 5 players by default
    const players = await loadPlayers();
    const topPlayers = playerUtils.findTopNMaxAmounts(players, 5);
    uiComponents.createPlayerTable(topPlayers, "topNPlayers");
});