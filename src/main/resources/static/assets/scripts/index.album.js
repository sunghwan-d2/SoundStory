var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
        height: '360',
        width: '640',
        videoId: '',
        playerVars: {
            'rel': 0, // 추천 영상 비활성화
        },
        events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
        }
    });
}

function onPlayerReady(event) {
    var playButton = document.querySelector('.play');
    var pauseButton = document.querySelector('.pause');
    playButton.addEventListener('click', function() {
        player.playVideo();
        playButton.style.display = 'none';
        pauseButton.style.display = 'inline-block';
    });
    pauseButton.addEventListener('click', function() {
        player.pauseVideo();
        playButton.style.display = 'inline-block';
        pauseButton.style.display = 'none';
    });

    // document.getElementById('volumeBar').addEventListener('input', function() {
    //     var volume = document.getElementById('volumeBar').value;
    //     player.setVolume(volume);
    // });

    var musicItems = document.querySelectorAll('.music-item');
    musicItems.forEach(function(item) {
        item.addEventListener('click', function() {
            var videoId = item.getAttribute('data-video-id');
            var title = item.querySelector('.title').textContent;
            var channel = item.querySelector('.channel').textContent;
            if (videoId) {
                document.getElementById('songTitle').textContent = title;
                document.getElementById('songArtist').textContent = channel;
                player.loadVideoById(videoId);
                player.playVideo();
                getVideoInfo(videoId);
            } else {
                console.error('Video ID is missing for this music item.');
            }
        });
    });

    setInterval(updateTimeDisplay, 1000);
}

function getVideoInfo(videoId) {
    var apiKey = 'AIzaSyC_SonTyICeFT-Y-iXRBLEv5M2sR166mrE'; // 자신의 API 키로 교체
    var url = 'https://www.googleapis.com/youtube/v3/videos?part=snippet,contentDetails&id=' + videoId + '&key=' + apiKey;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data.items.length > 0) {
                var title = data.items[0].snippet.title;
                var channelTitle = data.items[0].snippet.channelTitle;
                var duration = data.items[0].contentDetails.duration;
                document.getElementById('songTitle').textContent = title;
                document.getElementById('songArtist').textContent = channelTitle;
                document.getElementById('durationDisplay').textContent = formatDuration(duration);
            } else {
                console.error('No video details available for the provided video ID.');
            }
        })
        .catch(error => console.error('Error fetching video info:', error));
}

function formatDuration(duration) {
    var match = duration.match(/PT(\d+H)?(\d+M)?(\d+S)?/);
    var hours = (parseInt(match[1]) || 0);
    var minutes = (parseInt(match[2]) || 0);
    var seconds = (parseInt(match[3]) || 0);
    return [hours, minutes, seconds]
        .map(v => v < 10 ? "0" + v : v)
        .filter((v, i) => v !== "00" || i > 0)
        .join(":");
}

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.ENDED) {
        var playButton = document.querySelector('.play');
        var pauseButton = document.querySelector('.pause');
        playButton.style.display = 'inline-block';
        pauseButton.style.display = 'none';
    }
}

function updateTimeDisplay() {
    if (player && player.getDuration) {
        var currentTime = player.getCurrentTime();
        var duration = player.getDuration();
        document.getElementById('currentTimeDisplay').textContent = formatTime(currentTime);
        document.getElementById('progressBar').value = (currentTime / duration) * 1000;
    }
}

function formatTime(seconds) {
    var minutes = Math.floor(seconds / 60);
    seconds = Math.floor(seconds % 60);
    return minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
}
