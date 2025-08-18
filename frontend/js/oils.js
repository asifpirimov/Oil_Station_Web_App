const API_URL = "http://localhost:8080/api/oils";

async function loadOils() {
  const response = await fetch(API_URL);
  const oils = await response.json();

  const tbody = document.querySelector("#oilsTable tbody");
  tbody.innerHTML = "";

  oils.forEach(oil => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${oil.brandName}</td>
      <td>${oil.productName}</td>
      <td>${oil.oilType}</td>
      <td>${oil.viscosityGrade}</td>
      <td>${oil.price}</td>
      <td>
        <button onclick="viewOil(${oil.id})">View</button>
        <button onclick="editOil(${oil.id})">Edit</button>
        <button onclick="deleteOil(${oil.id})">Delete</button>
      </td>
    `;
    tbody.appendChild(row);
  });
}

function viewOil(id) {
  window.location.href = `oil_detail.html?id=${id}`;
}

function editOil(id) {
  window.location.href = `oil_form.html?id=${id}`;
}

async function deleteOil(id) {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  loadOils();
}

loadOils();
