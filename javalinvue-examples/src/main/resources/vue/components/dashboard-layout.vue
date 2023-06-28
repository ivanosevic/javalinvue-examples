<template id="dashboard-layout">
    <div>
        <dashboard-topbar></dashboard-topbar>
        <div class="container-fluid">
            <div class="row">
                <dashboard-sidebar></dashboard-sidebar>
                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <slot></slot>
                </main>
            </div>
        </div>
    </div>
</template>
<script>
app.component("dashboard-layout", {template: "#dashboard-layout"});
</script>
<style>
body {
    font-size: .875rem;
}
</style>