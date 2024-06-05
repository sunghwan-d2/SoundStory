const apiKey = '';
const videoId = '';


fetch(`https://www.googleapis.com/youtube/v3/videos?id=${videoId}&key=${apiKey}&part=snippet,contentDetails,statistics`)
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => console.error('Error:', error));

var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;

function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
        videoId: videoId,
        events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
        }
    });
}

const playPauseButton = document.getElementById('playPauseButton');
const currentTimeDisplay = document.getElementById('currentTimeDisplay');
const durationDisplay = document.getElementById('durationDisplay');

playPauseButton.addEventListener('click', () => {
    if (player.getPlayerState() === YT.PlayerState.PLAYING) {
        player.pauseVideo();
    } else {
        player.playVideo();
    }
});

function onPlayerReady(event) {
    updateProgressBar();
    updateDuration();
}

function onPlayerStateChange(event) {
    if (event.data === YT.PlayerState.PLAYING) {
        playPauseButton.innerHTML = '⏸';
        updateProgressBar();
    } else {
        playPauseButton.innerHTML = '⏯';
    }
}

function updateProgressBar() {
    setInterval(() => {
        const currentTime = player.getCurrentTime();
        const duration = player.getDuration();
        const progress = (currentTime / duration) * 100;

        progressBar.value = progress;
        currentTimeDisplay.innerHTML = formatTime(currentTime);
    }, 1000);
}

progressBar.addEventListener('input', () => {
    const duration = player.getDuration();
    const seekTo = (progressBar.value / 100) * duration;
    player.seekTo(seekTo, true);
});

function updateDuration() {
    setTimeout(() => {
        const duration = player.getDuration();
        durationDisplay.innerHTML = formatTime(duration);
    }, 1000);
}

function formatTime(time) {
    const minutes = Math.floor(time / 60);
    const seconds = Math.floor(time % 60);
    return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
}

const playerContainer = document.getElementById('player-container');

document.querySelectorAll('.album_list_body_list').forEach((row, index) => {
    row.addEventListener('click', () => {
        const videoId = row.getAttribute('data-video-id');
        playerContainer.style.display = 'block';
        player.loadVideoById(videoId);
        updateSongInfo(index);
    });
});

function updateSongInfo(index) {
    const songTitle = document.querySelector('.album_list_body_list:nth-child(' + (index + 1) + ') .album_list_body_title a').innerText;
    const songArtist = document.querySelector('.album_list_body_list:nth-child(' + (index + 1) + ') .album_list_body_artist a').innerText;

    document.getElementById('songTitle').innerText = songTitle;
    document.getElementById('songArtist').innerText = songArtist;
}
