<template id="sidebar-item">
    <li class="nav-item">
        <a class="nav-link" v-bind:href="to">
            <i :class="calculateIconClass"></i>
            {{ name }}
        </a>
    </li>
</template>
<script>

app.component("sidebar-item", {
  template: "#sidebar-item",
  props: {
    name: String,
    to: String,
    icon: String
  },
  computed: {
    calculateIconClass() {
      return `bi bi-${this.icon}`;
    }
  }
});


</script>
<style scoped>
.nav-link {
    font-weight: 500;
    color: #333;
}

.nav-link .bi {
    margin-right: 4px;
    color: #727272;
}

.nav-link.active {
    color: #2470dc;
}

.nav-link:hover .bi,
.nav-link.active .bi {
    color: inherit;
}
</style>