<template id="sidebar-heading">
    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
        <span>{{ name }}</span>
    </h6>
</template>
<script>
app.component("sidebar-heading", {
  template: "#sidebar-heading",
  props: {
    name: String
  }
});
</script>
<style>
.sidebar-heading {
    font-size: .75rem;
    text-transform: uppercase;
}
</style>