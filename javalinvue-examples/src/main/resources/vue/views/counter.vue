<template id="counter">
    <dashboard-layout>
        <page-header title="Counter Example"></page-header>
        <div>
            <p>Value: {{ value }}</p>
            <button class="btn btn-primary" @click="increment">Increment</button>
        </div>
    </dashboard-layout>
</template>
<script>
app.component("counter", {
  template: "#counter",
  data() {
    return {
      value: 0
    };
  },
  methods: {
    increment() {
      this.value++;
    }
  }
});
</script>
<style>

</style>