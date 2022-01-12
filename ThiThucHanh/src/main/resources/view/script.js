function home(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/cities",
        success: function (cities) {
            console.log(cities);
            let html = `
            <table cellpadding="7">
                <tr>
                    <th colspan="3"><h1>Danh sách thành phố</h1></th>
                    <th><button onclick="formCreateCity()">Thêm mới</button></th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Thành phố</th>
                    <th>Quốc gia</th>
                    <th></th>
                    <th></th>
                </tr>`
            for (let i = 0; i < cities.length; i++) {
                html += `<tr>
                            <td>${cities[i].id}</td>
                            <td><a href="#" onclick="viewCity(${cities[i].id})">${cities[i].name}</a></td>
                            <td>${cities[i].country.name}</td>
                            <td><a href="#" onclick="formEditCity(${cities[i].id})">Chỉnh sửa</a></td>
                            <td><a href="#" onclick="removeCity(${cities[i].id})">Xóa</a></td>
                        </tr>`
            }

            `</table>`
            document.getElementById("main").innerHTML = html
        }
    })
}

function viewCity(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/cities/" + id,
        success: function (city) {
            console.log(city)
            let view = `<table cellpadding="5">
                                    <tr>
                                        <th><h1>Thành phố ${city.name}</h1></th>
                                        <th><a href="#" onclick="home()"><h3>Danh sách thành phố</h3></a></th>
                                    </tr>
                                    <tr>
                                        <th>Tên: </th>
                                        <td>${city.name}</td>
                                    </tr>
                                    <tr>
                                        <th>Quốc gia: </th>
                                        <td>${city.country.name}</td>
                                    </tr>
                                    <tr>
                                        <th>Diện tích: </th>
                                        <td>${city.area}</td>
                                    </tr>
                                    <tr>
                                        <th>Dân số: </th>
                                        <td>${city.population}</td>
                                    </tr>
                                    <tr>
                                        <th>GDP: </th>
                                        <td>${city.gdp}</td>
                                    </tr>
                                    <tr>
                                        <th>Giới thiệu: </th>
                                        <td>${city.description}</td>
                                    </tr>
                                    <tr>
                                        <th></th>
                                        <td><button onclick="formEditCity(${id})">Chỉnh sửa</button>&ensp;&ensp;<button onclick="removeCity(${id})">Xóa</button></td>
                                    </tr>
                                </table>`;
            document.getElementById("main").innerHTML = view;
        }
    })
}

function formCreateCity() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/countries",
        success: function (countries) {
            console.log(countries);
            let form = `
                        <h1>Thêm 1 thành phố</h1>
                        <table cellpadding="5">
                            <tr>
                                <th>Tên: </th>
                                <td><input type="text" id="name"></td>
                            </tr>
                            <tr>
                                <th>Diện tích: </th>
                                <td><input type="number" id="area"></td>
                            </tr>
                            <tr>
                                <th>Dân số: </th>
                                <td><input type="number" id="population"></td>
                            </tr>
                            <tr>
                                <th>GDP: </th>
                                <td><input type="number" id="gdp"></td>
                            </tr>
                            <tr>
                                <th>Mô tả: </th>
                                <td><input type="text" id="description"></td>
                            </tr>
                            <tr>
                                <th>Quốc gia: </th>
                                <td>
                                    <select name="country" id="country">`
            for (let i = 0; i < countries.length; i++) {
                form += `<option value="${countries[i].id}">${countries[i].name}</option>`
            }
            form += `</select>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td><button onclick="saveCity()">Thêm mới</button></td>
                            </tr>
                        </table>`;
            document.getElementById("main").innerHTML = form;
        }
    })
}

function saveCity() {
    let city = {
        "name": document.getElementById("name").value,
        "area": document.getElementById("area").value,
        "population": document.getElementById("population").value,
        "gdp": document.getElementById("gdp").value,
        "description": document.getElementById("description").value,
        "country": {
            "id": document.getElementById("country").value
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'POST',
        url: 'http://localhost:8080/cities',
        data: JSON.stringify(city),
        success: function () {
            alert("Thêm mới thành công!")
            home()
        }
    })
}

function formEditCity(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/cities/" + id,
        success: function (city) {
            console.log(city)
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/countries",
                success: function (countries) {
                    console.log(countries);
                    let form = `
                        <h1>Sửa thông tin thành phố</h1>
                        <table cellpadding="5">
                            <tr>
                                <th>Tên: </th>
                                <td><input type="text" id="name" value="${city.name}"></td>
                            </tr>
                            <tr>
                                <th>Diện tích: </th>
                                <td><input type="number" id="area" value="${city.area}"></td>
                            </tr>
                            <tr>
                                <th>Dân số: </th>
                                <td><input type="number" id="population" value="${city.population}"></td>
                            </tr>
                            <tr>
                                <th>GDP: </th>
                                <td><input type="number" id="gdp" value="${city.gdp}"></td>
                            </tr>
                            <tr>
                                <th>Mô tả: </th>
                                <td><input type="text" id="description" value="${city.description}"></td>
                            </tr>
                            <tr>
                                <th>Quốc gia: </th>
                                <td>
                                    <select name="country" id="country">
                                    <option value="${city.country.id}">${city.country.name}</option>`
                    for (let i = 0; i < countries.length; i++) {
                        form += `<option value="${countries[i].id}">${countries[i].name}</option>`
                    }
                    form += `</select>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td><button onclick="updateCity(${id})">Cập nhật</button></td>
                            </tr>
                        </table>`;
                    document.getElementById("main").innerHTML = form;
                }
            })
        }
    })
}

function updateCity(id) {
    let city = {
        "name": document.getElementById("name").value,
        "area": document.getElementById("area").value,
        "population": document.getElementById("population").value,
        "gdp": document.getElementById("gdp").value,
        "description": document.getElementById("description").value,
        "country": {
            "id": document.getElementById("country").value
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'PUT',
        url: 'http://localhost:8080/cities/' + id,
        data: JSON.stringify(city),
        success: function () {
            alert("Cập nhật thành công!");
            home()
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function removeCity(id) {
    if (confirm("Are you sure?")) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            type: 'DELETE',
            url: 'http://localhost:8080/cities/' + id,
            success: function () {
                alert("Xóa thành công!")
                home()
            },
            error: function (error) {
                console.log(error)
            }
        })
    }
}




