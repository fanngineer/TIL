import cal from "./module2.js";

console.log(cal.title);

const app = new Vue({
  el: "#app",
  data() {
    return {
      num1: 0,
      num2: 0,
      op: "-",
      result: 0,
    };
  },
  methods: {
    doCal() {
      if (this.op === "+") {
        this.result = cal.add(this.num1, this.num2);
      } else {
        this.result = cal.sub(this.num1, this.num2);
      }
    },
  },
  watch: {
    op(val) {
      if (val === "+") {
        this.result = cal.add(this.num1, this.num2);
      } else {
        this.result = cal.sub(this.num1, this.num2);
      }
    },
  },
});
