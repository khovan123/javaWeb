<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Milk Management</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                display: flex;
                height: 100vh;
                background: linear-gradient(to bottom, #d8d8f6, #2c2c54);
            }
            .container {
                display: flex;
                width: 100%;
            }
            .sidebar {
                width: 20%;
                background: linear-gradient(to bottom, #2c2c54, #1a1a3b);
                padding: 20px;
                color: white;
            }
            .sidebar h2 {
                margin: 0 0 20px 0;
                font-size: 18px;
                text-transform: uppercase;
            }
            .category-item {
                padding: 10px;
                margin-bottom: 5px;
                cursor: pointer;
                background-color: #4a4a8c;
                border-radius: 5px;
            }
            .category-item:hover {
                background-color: #5b5b9d;
            }
            .category-item.active {
                background-color: #6b6bad;
            }
            .main-content {
                width: 80%;
                padding: 20px;
                background-color: #f5f5f5;
                overflow-y: auto;
            }
            .main-content h1 {
                margin: 0 0 20px 0;
                font-size: 24px;
                text-align: center;
                text-transform: uppercase;
            }
            .milk-grid {
                display: grid;
                grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
                gap: 20px;
            }
            .milk-item {
                background-color: #e0e0e0;
                border-radius: 10px;
                padding: 10px;
                text-align: center;
                cursor: pointer;
                position: relative;
            }
            .milk-item .placeholder {
                width: 100%;
                height: 100px;
                background-color: #d0d0d0;
                border-radius: 5px;
            }
            .milk-item .price {
                position: absolute;
                top: 5px;
                right: 5px;
                background-color: #4a4a4a;
                color: white;
                padding: 2px 5px;
                border-radius: 5px;
                font-size: 12px;
            }
            .milk-item .name {
                margin: 10px 0 0 0;
                font-size: 14px;
            }
            .milk-item .operations {
                margin-top: 10px;
                display: flex;
                justify-content: center;
                gap: 5px;
            }
            .milk-item .operations button {
                padding: 5px 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 12px;
            }
            .milk-item .operations .update-btn {
                background-color: #4a4a8c;
                color: white;
            }
            .milk-item .operations .update-btn:hover {
                background-color: #5b5b9d;
            }
            .milk-item .operations .delete-btn {
                background-color: #ff4444;
                color: white;
            }
            .milk-item .operations .delete-btn:hover {
                background-color: #ff6666;
            }
            .dialog {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translateY(-50%);
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.2);
                z-index: 1000;
                width: 250px;
            }
            .dialog h3 {
                margin: 0 0 15px 0;
                font-size: 16px;
            }
            .dialog input, .dialog select {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }
            .dialog button {
                width: 100%;
                padding: 8px;
                background-color: #4a4a8c;
                color: white;
                border: none;
                border-radius: 20px;
                cursor: pointer;
            }
            .dialog button:hover {
                background-color: #5b5b9d;
            }
            .error {
                color: red;
                font-size: 12px;
            }
            .add-btn {
                margin: 20px 0;
                padding: 10px 20px;
                background-color: #4a4a8c;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .add-category-btn {
                margin: 20px 0;
                padding: 10px 20px;
                background-color: #6e6ea3;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .add-category-btn:hover {
                background-color: #6e6ea3;
            }

            .add-btn:hover {
                background-color: #5b5b9d;
            }

            .flex {
                display: flex;
                gap: 16px;
                justify-content: space-between;
                align-items: center;
            }

            .milkSearch {
                border:none;
                padding: 8px 10px;
                border: 2px solid #6e6ea3;
                border-radius: 5px;
                color: #6e6ea3;
            }

            .milkSearch:focus {
                outline: none;
            }

            .small {
                font-size: 14px;
            }

            .sort-btn {
                margin: 20px 0;
                padding: 9px 18px;
                background-color: #4a4a8c;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                text-decoration: none;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="sidebar">
                <h2>Category</h2>
                <div class="category-item" onclick="toggleSelection(this)">
                    All
                </div>
                <c:forEach items="${categories}" var="category">
                    <div class="category-item" data-category-id="${category.id}" onclick="toggleSelection(this)">
                        ${category.name}
                    </div>
                </c:forEach>
                <div class="category-item add-category-btn" onclick="showAddCategoryDialog()">
                    Add new category
                </div>
            </div>

            <div class="main-content">
                <h1>Milk Management</h1>
                <div>
                    <input type="search" id="searchMilk" onkeyup="handleSearchMilk()" onfocus="handleSearchMilk()" placeholder="Search milk" class="milkSearch"/>                        
                    <button class="add-btn" onclick="showAddDialog()">Add New Milk</button>
                    <a class="sort-btn" href="milk-sort?order=asc">A-Z</a>
                    <a class="sort-btn" href="milk-sort?order=desc">Z-A</a>
                </div>
                <div class="milk-grid" id="milkGrid">
                    <c:forEach items="${milks}" var="milk">
                        <div class="milk-item"  data-category-id="${milk.categoryId}">
                            <span class="price">${milk.price}</span>
                            <div class="placeholder"></div>
                            <p class="name">${milk.name}</p>
                            <p class="small">${milk.hasSugar?'Sugar':'No sugar'}</p>
                            <p class="small">${milk.original}</p>
                            <div class="operations">
                                <button class="update-btn" onclick="showUpdateDialog(${milk.id}, '${milk.name}', ${milk.categoryId}, ${milk.price}, '${milk.overview}', '${milk.original}', ${milk.hasSugar})">Update</button>
                                <button class="delete-btn" onclick="showDeleteDialog(${milk.id})">Delete</button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="dialog" id="addCategoryDialog">
            <h3>Add Category</h3>
            <form id="addCategoryForm" method="post" action="category-add">
                <div>
                    Name: <input type="text" id="addCategoryName" name="categoryName"><br>
                </div>
                <div>
                    Description: <input type="text" id="addCategoryDescription" name="categoryDescription"><br>
                </div>
                <button type="submit">Add</button>
            </form>
        </div>

        <div class="dialog" id="addDialog">
            <h3>Add Milk</h3>
            <form id="addForm" action="milk-add" method="post">
                <div>
                    Name: <input type="text" id="addMilkName" name="milkName"><br>
                </div>
                <div>
                    Group: 
                    <select id="addCategoryMilkId" name="categoryMilkId">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    Price: <input type="number" id="addMilkPrice" name="milkPrice"><br>
                </div>
                <div>
                    Overview: <textarea id="addMilkOverview" name="milkOverview" rows="5" cols="31"></textarea>
                </div>
                <div>
                    Original: <input type="text" id="addMilkOriginal" name="milkOriginal"/>
                </div>
                <div>
                    Sugar:
                    <select id="addMilkHasSugar" name="milkHasSugar">
                        <option value="1">Has Sugar</option>
                        <option value="0">No Sugar</option>
                    </select>
                </div>
                <button type="submit">Add</button>
            </form>
        </div>

        <div class="dialog" id="updateDialog">
            <h3>Update Milk</h3>
            <form id="updateForm" action="milk-update" method="post">
                <input type="hidden" id="milkId" name="milkId"/>
                <div>
                    Name: <input type="text" id="milkName" name="milkName"/>
                </div>
                <div>
                    Group: 
                    <select id="categoryMilkId" name="categoryMilkId">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    Price: <input type="number" id="milkPrice" name="milkPrice"/>
                </div>
                <div>
                    Overview: <textarea id="milkOverview" name="milkOverview" rows="5" cols="31"></textarea>
                </div>
                <div>
                    Original: <input type="text" id="milkOriginal" name="milkOriginal"/>
                </div>
                <div>
                    Sugar: 
                    <select id="milkHasSugar" name="milkHasSugar">
                        <option value="1">Has Sugar</option>
                        <option value="0">No Sugar</option>
                    </select>
                </div>
                <button type="submit">Update</button>
            </form>
        </div>

        <div class="dialog" id="deleteDialog">
            <h3>Delete Milk</h3>
            <form id="deleteForm" action="milk-delete" method="post">
                <input type="hidden" id="deletedMilkId" name="milkId">     
                <div class="flex">
                    <button type="submit" style="background-color: #ff4444">YES</button>
                    <button type="reset" onclick="closeDialog('deleteDialog')">NO</button> 
                </div>
            </form>
        </div>

        <script>
            function showAddCategoryDialog() {
                document.getElementById('addCategoryDialog').style.display = 'block';
            }

            function showAddDialog() {
                document.getElementById('addDialog').style.display = 'block';
            }

            function showUpdateDialog(id, name, categoryId, price, overview, milkOriginal, hasSugar) {
                document.getElementById('milkId').value = id;
                document.getElementById('milkName').value = name;
                document.getElementById('categoryMilkId').value = categoryId;
                document.getElementById('milkPrice').value = price;
                document.getElementById('milkOverview').value = overview;
                document.getElementById('milkOriginal').value = milkOriginal;
                document.getElementById('milkHasSugar').value = hasSugar ? "1" : "0";
                document.getElementById('updateDialog').style.display = 'block';
            }

            function showDeleteDialog(id) {
                document.getElementById('deletedMilkId').value = id;
                document.getElementById('deleteDialog').style.display = 'block';
            }

            function closeDialog(dialogId) {
                document.getElementById(dialogId).style.display = 'none';
            }

            function toggleSelection(selectEl) {
                document.querySelectorAll('.category-item').forEach(item => {
                    item.classList.remove('active');
                })
                selectEl.classList.add('active');
                let milkGridEl = document.getElementById('milkGrid');
                let milkItemEls = milkGridEl.getElementsByClassName('milk-item');
                if (selectEl.dataset.categoryId == null) {
                    for (let milkItem of milkItemEls) {
                        milkItem.style.display = 'block';
                    }
                    return;
                }
                for (let milkItem of milkItemEls) {
                    if (selectEl.dataset.categoryId.toString() === milkItem.dataset.categoryId.toString()) {
                        milkItem.style.display = 'block';
                    } else {
                        milkItem.style.display = 'none';
                    }
                }
            }

            function handleSearchMilk() {
                let searchEl = document.getElementById('searchMilk');
                let searchInput = searchEl.value.toString().toLowerCase();
                let milkGridEl = document.getElementById('milkGrid');
                let milkItemEls = milkGridEl.getElementsByClassName('milk-item');
                for (let milkItem of milkItemEls) {
                    let nameEl = milkItem.querySelector('p.name')
                    let name = nameEl.textContent || nameEl.innerText;
                    if (name.toString().toLowerCase().indexOf(searchInput) > -1) {
                        milkItem.style.display = 'block';
                    } else {
                        milkItem.style.display = 'none';
                    }
                }
            }

            document.addEventListener('click', (e) => {
                const addCategoryDialog = document.getElementById('addCategoryDialog');
                const addDialog = document.getElementById('addDialog');
                const updateDialog = document.getElementById('updateDialog');
                const deleteDialog = document.getElementById('deleteDialog');
                if (addCategoryDialog.style.display === 'block' && !addCategoryDialog.contains(e.target) && !e.target.classList.contains('add-category-btn')) {
                    closeDialog('addCategoryDialog');
                }
                if (addDialog.style.display === 'block' && !addDialog.contains(e.target) && !e.target.classList.contains('add-btn')) {
                    closeDialog('addDialog');
                }
                if (updateDialog.style.display === 'block' && !updateDialog.contains(e.target) && !e.target.classList.contains('update-btn')) {
                    closeDialog('updateDialog');
                }
                if (deleteDialog.style.display === 'block' && !deleteDialog.contains(e.target) && !e.target.classList.contains('delete-btn')) {
                    closeDialog('deleteDialog');
                }
                let searchEl = document.getElementById('searchMilk');
                let milkGridEl = document.getElementById('milkGrid');
                let milkItemEls = milkGridEl.getElementsByClassName('milk-item');
                console.log(e.target.classList);
                console.log(e.target.value);

                if (e.target.value === undefined && !e.target.classList.contains('milk-item') && !e.target.classList.contains('placeholder')) {
                    if (!e.target.classList.contains('category-item')) {
                        for (let milkItem of milkItemEls) {
                            milkItem.style.display = 'block';
                        }
                    }
                    searchEl.value = '';
                }
            });
        </script>
    </body>
</html>