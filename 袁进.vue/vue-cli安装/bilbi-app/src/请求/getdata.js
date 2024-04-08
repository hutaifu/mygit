export default {
  async getdata() {
    let resp = await fetch("/xlive/web-interface/v1/index/RoomForWebMainHover");
    let data = await resp.json();
    console.log(data);
  },
};
