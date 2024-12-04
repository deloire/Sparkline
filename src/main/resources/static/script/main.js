const tg = window.Telegram.WebApp;

tg.BackButton.show();

tg.BackButton.onClick(() => {
    window.history.back(); // Возврат на предыдущую страницу
});

// Общая функция для отправки формы
function submitForm(event, endpoint) {
    event.preventDefault(); // Предотвращаем стандартное поведение формы

    const taskDescription = document.getElementById("taskDescription").value;
    const currency = document.getElementById("currency").value;
    const budget = document.getElementById("budget").value;
    const detailedTask = document.getElementById("detailedTask").value;

    if (!taskDescription || !currency || !budget || !detailedTask) {
        alert('Пожалуйста, заполните все поля');
        return;
    }

    const taskData = {
        description: taskDescription,
        currency: currency,
        budget: parseFloat(budget),
        detailedTask: detailedTask
    };

    fetch(endpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(taskData)
    }).then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    }).then(data => {
        // Логика для обновления интерфейса после успешного запроса

        // Для Telegram WebApp
        if (window.Telegram && window.Telegram.WebApp) {
            window.Telegram.WebApp.sendData(JSON.stringify(data));
        }

        // Переход на другую страницу
        window.location.href = '/order-handling'; // Замените '/new-page' на нужный URL

        // Очистка формы после отправки (если необходимо)
        document.querySelector('.form-container').reset();
    }).catch(error => {
        console.error('Error:', error);
    });
}

// Получаем текущий URL страницы
const currentPage = window.location.pathname;

// Определяем конечную точку в зависимости от текущей страницы
let endpoint;
switch (currentPage) {
    case '/order-website':
        endpoint = '/order-website';
        break;
    case '/order-bot':
        endpoint = '/order-bot';
        break;
    case '/order-miniapp':
        endpoint = '/order-miniapp';
        break;
    case '/order-parsing':
        endpoint = '/order-parsing';
        break;
    default:
        console.error('Unknown page');
}

document.addEventListener('DOMContentLoaded', function() {
    const submitButton = document.getElementById('submitButton');

    if (submitButton) {
        submitButton.addEventListener('click', (event) => submitForm(event, endpoint));
    } else {
        console.error('Submit button not found');
    }

    // Инициализация Telegram WebApp
    if (window.Telegram && window.Telegram.WebApp) {
        window.Telegram.WebApp.ready();
    }
});