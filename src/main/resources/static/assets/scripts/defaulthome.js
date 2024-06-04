function setDefaultHomeUrl() {
    if (performance.navigation.type === 1) {
        window.location.href = '/';
    }
}
window.onload = setDefaultHomeUrl;
