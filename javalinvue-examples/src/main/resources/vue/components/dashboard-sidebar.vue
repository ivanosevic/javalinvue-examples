<template id="dashboard-sidebar">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
        <div class="position-sticky pt-3">
            <ul class="nav flex-column">
                <sidebar-heading name="Main"></sidebar-heading>
                <sidebar-item name="Dashboard" to="/dashboard" icon="house"></sidebar-item>
                <sidebar-item name="Counter" to="/counter" icon="arrow-clockwise"></sidebar-item>
                <sidebar-item name="Server Side States" to="/server-side-example" icon="file-earmark-text"></sidebar-item>
                <sidebar-item name="Suppliers" to="/suppliers" icon="people-fill"></sidebar-item>
            </ul>
        </div>
    </nav>
</template>
<script>
app.component("dashboard-sidebar", {template: "#dashboard-sidebar"});
</script>
<style scoped>
.sidebar {
    position: fixed;
    top: 0;
    /* rtl:raw:
    right: 0;
    */
    bottom: 0;
    /* rtl:remove */
    left: 0;
    z-index: 100; /* Behind the navbar */
    padding: 48px 0 0; /* Height of navbar */
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
}

@media (max-width: 767.98px) {
    .sidebar {
        top: 5rem;
    }
}

.sidebar-sticky {
    height: calc(100vh - 48px);
    overflow-x: hidden;
    overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
}

.sidebar .nav-link {
    font-weight: 500;
    color: #333;
}

.sidebar .nav-link .feather {
    margin-right: 4px;
    color: #727272;
}

.sidebar .nav-link.active {
    color: #2470dc;
}

.sidebar .nav-link:hover .feather,
.sidebar .nav-link.active .feather {
    color: inherit;
}

.sidebar-heading {
    font-size: .75rem;
}
</style>