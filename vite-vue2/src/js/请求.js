export default {
  async getChannels() {
    var resp = await fetch(
      "/x/web-show/wbi/res/locs?pf=0&ids=3449&w_rid=6c54923714633c37b12011f0b31fdfcc&wts=1709480",
      {
      }
    );
    var data = await resp.json();
  
  },
};
