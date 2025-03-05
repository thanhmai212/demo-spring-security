<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Creating RSA Key Pair with OpenSSL</title>
    <style>
        .code-block {
            background-color: #f4f4f4;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
            position: relative;
            overflow-x: auto;
            margin: 10px 0;
            font-family: 'Courier New', Courier, monospace;
        }
        .copy-button {
            position: absolute;
            top: 5px;
            right: 5px;
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 12px;
        }
        .copy-button:hover {
            background-color: #0056b3;
        }
        h2, h3 {
            color: #333;
            margin-top: 20px;
        }
        ul {
            list-style-type: none;
            padding-left: 0;
        }
    </style>
</head>
<body>
    <h2>Các bước tạo cặp khóa RSA bằng OpenSSL</h2>
    <ul>
        <li>
            <h3>Bước 1: Cài đặt OpenSSL</h3>
            <div class="code-block">
                <button class="copy-button" onclick="copyCode('code1')">Copy</button>
                <pre><code id="code1">
choco install openssl -y
                </code></pre>
            </div>
        </li>
        <li>
            <h3>Bước 2: Di chuyển vào dự án</h3>
            <!-- Không có code block cho bước này, chỉ là mô tả -->
        </li>
        <li>
            <h3>Bước 3: Tạo khóa bí mật (Private Key)</h3>
            <div class="code-block">
                <button class="copy-button" onclick="copyCode('code2')">Copy</button>
                <pre><code id="code2">
openssl genrsa -out private_key.pem 2048
                </code></pre>
            </div>
        </li>
        <li>
            <h3>Bước 4: Tạo khóa công khai (Public Key) từ khóa bí mật</h3>
            <div class="code-block">
                <button class="copy-button" onclick="copyCode('code3')">Copy</button>
                <pre><code id="code3">
openssl rsa -in private_key.pem -pubout -out public_key.pem
                </code></pre>
            </div>
        </li>
    </ul>

    <script>
        function copyCode(codeId) {
            const codeElement = document.getElementById(codeId);
            const textToCopy = codeElement.textContent;

            navigator.clipboard.writeText(textToCopy)
                .then(() => {
                    alert("Code copied to clipboard!");
                })
                .catch(err => {
                    console.error("Failed to copy: ", err);
                    alert("Failed to copy code. Please copy manually.");
                });
        }
    </script>
</body>
</html>