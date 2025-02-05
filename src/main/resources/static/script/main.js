const tg = window.Telegram.WebApp;

if (window.location.pathname === '/') {
    tg.BackButton.hide();
} else {
    tg.BackButton.show();
    tg.BackButton.onClick(() => {
        window.history.back();
    });
}

// Общая функция для отправки формы
function submitForm(event, endpoint) {
    event.preventDefault(); // Предотвращаем стандартное поведение формы

    const taskDescription = document.getElementById("taskDescription").value;
    const currency = document.getElementById("currency").value;
    const budget = document.getElementById("budget").value;
    const detailedTask = document.getElementById("detailedTask").value;

    if (!taskDescription || !currency || !budget || !detailedTask) {
        alert('Not all fields are filled in or something is filled in incorrectly!');
        return;
    }

    const taskData = {
        description: taskDescription,
        currency: currency,
        budget: parseFloat(budget),
        detailedTask: detailedTask,
        telegramName: 'https://t.me/' + tg.initDataUnsafe.user.username
    };

    fetch(endpoint + '?telegramName=' + taskData.telegramName, {
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
        window.location.href = '/order-handling';

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

    // Новый код для страницы подтверждения заказа
    if (currentPage === '/order-handling') {
        // Анимация галочки
        const checkmark = document.querySelector('.checkmark__check');
        const circle = document.querySelector('.checkmark__circle');

        if (checkmark && circle) {
            checkmark.style.strokeDasharray = '48';
            checkmark.style.strokeDashoffset = '48';
            circle.style.strokeDasharray = '166';
            circle.style.strokeDashoffset = '166';

            checkmark.style.transition = 'stroke-dashoffset 0.5s ease-in-out 0.3s';
            circle.style.transition = 'stroke-dashoffset 0.5s ease-in-out';

            setTimeout(() => {
                circle.style.strokeDashoffset = '0';
                checkmark.style.strokeDashoffset = '0';
            }, 100);
        }

        // Обработка клика по ссылке "Сделать еще заказ"
        const newOrderLink = document.getElementById('newOrderLink');
        if (newOrderLink) {
            newOrderLink.addEventListener('click', function(e) {
                e.preventDefault();
                window.location.href = '/';
            });
        }
    }
});

