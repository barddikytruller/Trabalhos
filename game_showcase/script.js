document.addEventListener('keydown', function(event) {
    if (event.key === 'f' || event.key === 'F') {
        document.body.classList.add('reveal');
    }
});

document.addEventListener('keydown', function(event) {
    if (event.key === 'f' || event.key === 'F') {
        document.body.classList.add('reveal');
        document.getElementById('press-f').style.display = 'none';
    }
});

document.addEventListener('keydown', function(event) {
    if (event.key === 'f' || event.key === 'F') {
        document.body.classList.add('reveal');
        document.getElementById('red-ball').style.display = 'block';
    }
});