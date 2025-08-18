const API_URL = "http://localhost:8080/api/oils";
const urlParams = new URLSearchParams(window.location.search);
const oilId = urlParams.get("id");

async function loadOil() {
  const response = await fetch(`${API_URL}/${oilId}`);
  const oil = await response.json();

  const detailsDiv = document.getElementById("oilDetails");
  detailsDiv.innerHTML = `
    <p><strong>Brand:</strong> ${oil.brandName}</p>
    <p><strong>Product:</strong> ${oil.productName}</p>
    <p><strong>Type:</strong> ${oil.oilType}</p>
    <p><strong>Viscosity:</strong> ${oil.viscosityGrade}</p>
    <p><strong>Price:</strong> ${oil.price}</p>
  `;
}

loadOil();
