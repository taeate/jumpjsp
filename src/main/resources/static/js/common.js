console.log("hi");

const sunIcon = document.querySelector(".sun");
const moonIcon = document.querySelector(".moon");
const jb = document.querySelector('[data-theme]').getAttribute('data-theme');
console.log(jb);

const userTheme = localStorage.getItem("theme");
const systemTheme = window.matchMedia("(prefers-color-scheme: halloween").matches;

const iconToggle = () => {
    moonIcon.classList.toggle("display-none");
    sunIcon.classList.toggle("display-none");
};

const themeCheck = () => {
    if (jb === "halloween" || (!jb && systemTheme)) {
        document.querySelector('[data-theme]').setAttribute( 'data-theme', 'halloween');
        moonIcon.classList.add("display-none");
        return;
    }
    sunIcon.classList.add("display-none");
};

const themeSwitch = () => {
    if (document.querySelector('[data-theme]').getAttribute('data-theme') == "halloween") {
        document.querySelector('[data-theme]').setAttribute( 'data-theme', 'light');
        localStorage.setItem("theme", "light");
        iconToggle();
        return;
    }
    document.querySelector('[data-theme]').setAttribute( 'data-theme', 'halloween');
    localStorage.setItem("theme", "halloween");
    iconToggle();
};

sunIcon.addEventListener("click", () => {
    themeSwitch();
});

moonIcon.addEventListener("click", () => {
    themeSwitch();
});

themeCheck();