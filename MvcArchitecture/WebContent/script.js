<script>
document.addEventListener("DOMContentLoaded", function () {
    const mainTabs = document.querySelectorAll("#main-tabs > li");

    mainTabs.forEach(tab => {
        tab.addEventListener("click", function () {
            // Hide all subtabs
            document.querySelectorAll(".sub-tabs").forEach(subtab => subtab.style.display = "none");

            // Display subtabs of the clicked main tab
            const subTabs = tab.querySelector(".sub-tabs");
            if (subTabs) {
                subTabs.style.display = "block";
            }

            // Add logic to load content based on the selected tab and subtab
            const tabId = tab.querySelector("a").getAttribute("href").substring(1);
            loadContent(tabId);
        });
    });

    function loadContent(tabId) {
        // Fetch and display content based on the selected tab and subtab
        const contentSection = document.getElementById("content");
        let content = "";

        switch (tabId) {
            case "home":
                content = "<p>Welcome to our school website!</p>";
                break;
            case "about-college":
                content = "<p>About our college...</p>";
                break;
            case "message1":
                content = "<p>Message 1...</p>";
                break;
            case "message2":
                content = "<p>Message 2...</p>";
                break;
            // Add cases for other tabs and subtabs
            default:
                content = "<p>Content not available.</p>";
        }

        contentSection.innerHTML = content;
    }
});
</script>