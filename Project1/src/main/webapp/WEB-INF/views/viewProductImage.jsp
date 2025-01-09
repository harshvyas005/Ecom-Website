<!DOCTYPE html>
<html>
<head>
    <title>Product Image</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fa;
            color: #333;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            font-size: 2.5em;
            margin-top: 50px;
            font-weight: bold;
        }
        .image-container {
            display: inline-block;
            max-width: 100%; /* Increased max-width for larger container */
            padding: 20px;
            margin-top: 20px;
            border: 2px solid #ddd;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out;
        }
        .image-container:hover {
            transform: scale(1.05);
        }
        img {
            width: 100%;
            max-width: 1000px; /* Increased max-width for larger image */
            height: auto;
            border-radius: 8px;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            font-size: 1.1em;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 12px 25px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Product Image</h1>
    <div class="image-container">
        <img src="${path}" alt="Product Image" />
    </div>
    <br>
    <a href="/userproducts" class="back-link">Back to Product List</a>
</body>
</html>
