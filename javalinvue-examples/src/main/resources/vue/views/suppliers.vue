<template id="suppliers">
    <dashboard-layout>
        <page-header title="Suppliers"></page-header>
        <suppliers-table :suppliers="suppliers"></suppliers-table>
    </dashboard-layout>
</template>
<script>
app.component("suppliers", {
  template: "#suppliers",
  data: () => ({
    suppliers: new LoadableData("/api/v1/suppliers"),
  }),
  created() {
    this.suppliers.refresh();
  }
});
</script>
<style>

</style>