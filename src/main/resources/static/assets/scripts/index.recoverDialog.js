const recoverDialog = document.getElementById('recoverDialog');
const cancelButton = document.querySelector('[rel="cancelButton"]');
const showRecover = () => {
    loginForm.hide();
    recoverDialog.emailRecoverForm['nickname'].value = '';
    recoverDialog.passwordRecoverForm['emailSalt'].value = '';
    recoverDialog.passwordRecoverForm['email'].enable().value = '';
    recoverDialog.passwordRecoverForm['emailSend'].enable();
    recoverDialog.passwordRecoverForm['emailCode'].disable().value = '';
    recoverDialog.passwordRecoverForm['emailVerify'].disable();
    recoverDialog.passwordRecoverForm['password'].disable().value = '';
    recoverDialog.passwordRecoverForm['passwordCheck'].disable().value = '';
    recoverDialog.querySelector('[name="recoverType"][value="email"]').checked = true;
    recoverDialog.show();
    cover.show(() => {
        recoverDialog.hide();
        cover.hide();
    });
};

recoverDialog.emailRecoverForm = recoverDialog.querySelector('[rel="emailRecoverForm"]');
recoverDialog.passwordRecoverForm = recoverDialog.querySelector('[rel="passwordRecoverForm"]');

recoverDialog.querySelector('[rel="cancelButton"]').addEventListener('click', () => showLogin());

document.body.querySelectorAll('[rel="showRecoverCaller"]').forEach(el => el.addEventListener('click', e => {
    e.preventDefault();
    showRecover();
}));

cancelButton.addEventListener('click', () => {
    recoverDialog.classList.remove('-visible');
});