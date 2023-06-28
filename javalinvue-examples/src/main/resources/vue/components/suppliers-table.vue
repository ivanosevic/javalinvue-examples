<template id="suppliers-table">
    <section>
        <div v-if="suppliers.loading">
            <h2 class="text-center">Loading suppliers ...</h2>
        </div>
        <div v-if="suppliers.loadError">
            <h2 class="text-center">Failed to load suppliers ({{ suppliers.loadError.text }})</h2>
        </div>
        <div v-if="suppliers.loaded">
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Lastname</th>
                        <th scope="col">Country</th>
                        <th scope="col">Email</th>
                        <th scope="col">Delivery Time (In Days)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="supplier-row" v-for="supplier in suppliers.data" @click="seeSuppliersDetails(supplier)">
                        <td>{{ supplier.name }}</td>
                        <td>{{ supplier.lastname }}</td>
                        <td>{{ supplier.country }}</td>
                        <td>{{ supplier.email }}</td>
                        <td>{{ supplier.deliveryTimeInDays }}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</template>
<script>
app.component("suppliers-table", {
  template: "#suppliers-table",
  props: {
    suppliers: Object
  },
  methods: {
    seeSuppliersDetails(data) {
      const id = data.id;
      const link = `/suppliers/${id}`;
      window.location.assign(link);
    }
  }
});
</script>
<style scoped>
.supplier-row:hover {
    cursor: pointer;
    background-color: #2470dc;
}
</style>