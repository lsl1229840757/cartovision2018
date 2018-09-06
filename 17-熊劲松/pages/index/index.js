//index.js
//获取应用实例
const app = getApp()
var counting = 0
var cut=0
var jsq=5
Page({
  data: {
    sor:'pic-1.png',
    motto: '屠龙宝刀点击就送',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },

 butright:function(){
     counting=counting+1
   cut = (counting + 5 + jsq) % 5
   if (cut == 0) {
     jsq = jsq + 5
   }
    if(cut%5 < 2)
   {
     var pictur = 'pic-'+(cut+1)+'.png'
      this.setData({ motto: "屠龙宝刀点击就送" })
   }
   else{
      pictur = 'pic-' + (cut+ 1) + '.jpg'
      if (cut == 3) { 
        this.setData({motto: "万物皆虚，万事皆允"})}
      else if (cut == 4) {
        this.setData({
          motto: "命运石之门的选择"
        })
      }
      else { this.setData({ motto: "既已伤，何故空留痕" })}
   }
   
   this.setData({sor:pictur})
 },
butleft: function () {
    counting = counting - 1
    cut = (counting + 5 + jsq) % 5
    if(cut==0)
    {
      jsq = jsq + 5
    }
        if (cut % 5 < 2) {
      var pictur = 'pic-' + (cut + 1) + '.png'
     this.setData({ motto: "屠龙宝刀点击就送" })
    }
    else {
      pictur = 'pic-' + (cut + 1) + '.jpg'
      if (cut == 3) {
        this.setData({ motto: "万物皆虚，万事皆允" })
      }
      else if(cut == 4){
        this.setData({
          motto:"命运石之门的选择"
        })
      }
      else { this.setData({ motto: "既已伤，何故空留痕" }) }
    }

    this.setData({ sor: pictur })
  },
  song:function(){
    if(cut== 4) wx.playBackgroundAudio({
      dataUrl: 'https://bjbgp01.baidupcs.com/file/7d7a73915406783e6cf1098ec1fa7003?bkt=p3-14007d7a73915406783e6cf1098ec1fa7003ce2c41df0000001f5abe&fid=4130625638-250528-657044194944935&time=1536229714&sign=FDTAXGERLQBHSKW-DCb740ccc5511e5e8fedcff06b081203-LwGo0pQSDLdLbjx%2FUXxMzDLxPaQ%3D&to=75&size=2054846&sta_dx=2054846&sta_cs=1&sta_ft=mp3&sta_ct=0&sta_mt=0&fm2=MH%2CQingdao%2CAnywhere%2C%2Chubei%2Cce&resv0=cdnback&resv1=0&vuk=4130625638&iv=0&htype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=14007d7a73915406783e6cf1098ec1fa7003ce2c41df0000001f5abe&sl=76480590&expires=8h&rt=sh&r=571212680&mlogid=5769674792149097194&vbdid=57844512&fin=%E9%98%BF%E4%BF%9D%E5%89%9B+%28%E3%81%82%E3%81%BC+%E3%81%9F%E3%81%91%E3%81%97%29+-+Believe+me.mp3&fn=%E9%98%BF%E4%BF%9D%E5%89%9B+%28%E3%81%82%E3%81%BC+%E3%81%9F%E3%81%91%E3%81%97%29+-+Believe+me.mp3&rtype=1&dp-logid=5769674792149097194&dp-callid=0.1.1&hps=1&tsl=80&csl=80&csign=2gwWVGVOXP%2FPhphqH%2BOnI6W79To%3D&so=0&ut=6&uter=4&serv=0&uc=3616567821&ti=26fa64dbec288224279fc5b35c2b109968db25fea3fe3dd9305a5e1275657320&by=themis',
  title: 'Believe Me'
});
   else if(cut==3) wx.playBackgroundAudio({
  dataUrl: 'https://bjbgp01.baidupcs.com/file/8eb32024ce7998f6dcbcddaf3a13869b?bkt=p3-00000850013672f2860f20d1ee33dcc6b558&fid=4130625638-250528-942976457773491&time=1536210814&sign=FDTAXGERLQBHSKW-DCb740ccc5511e5e8fedcff06b081203-N%2FUyBWMSrENPBziDEDKsXmNsW%2Fo%3D&to=75&size=8583940&sta_dx=8583940&sta_cs=0&sta_ft=mp3&sta_ct=0&sta_mt=0&fm2=MH%2CYangquan%2CAnywhere%2C%2Chubei%2Cce&resv0=cdnback&resv1=0&vuk=4130625638&iv=0&htype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=00000850013672f2860f20d1ee33dcc6b558&sl=76480590&expires=8h&rt=sh&r=642886308&mlogid=5764601498037551650&vbdid=57844512&fin=2.mp3&fn=2.mp3&rtype=1&dp-logid=5764601498037551650&dp-callid=0.1.1&hps=1&tsl=80&csl=80&csign=2gwWVGVOXP%2FPhphqH%2BOnI6W79To%3D&so=0&ut=6&uter=4&serv=0&uc=3616567821&ti=648eaef5c3fa81d1476df001d3b74bce97e3f29726013ea0&by=themis',
  title: 'Ezio\'s Family'
});
else if(cut==2){
  wx.playBackgroundAudio({
    dataUrl: 'https://d11.baidupcs.com/file/d73aa49d13e75f25c4317ca4bb1a58fe?bkt=p3-0000364194ac5b11a6f1c7827397c25e2ad1&xcode=8046d0a06de6b4ea15ed55787863691458ff2d0c239bcc0dc986197226ce7f9bec61b92f49a892232f462421052e0e91316128a2cdfcce4d&fid=2130917896-250528-685936671912264&time=1536228848&sign=FDTAXGERLQBHSK-DCb740ccc5511e5e8fedcff06b081203-%2FgRa2u9rN%2BOaBJQXKhxfukai3UI%3D&to=d11&size=9232565&sta_dx=9232565&sta_cs=161717&sta_ft=mp3&sta_ct=5&sta_mt=5&fm2=MH%2CYangquan%2CAnywhere%2C%2Chubei%2Cce&resv0=cdnback&resv1=0&vuk=4130625638&iv=0&htype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=0000364194ac5b11a6f1c7827397c25e2ad1&sl=76480590&expires=8h&rt=sh&r=969094530&mlogid=5769442373193499954&vbdid=57844512&fin=%E5%8F%AF%E8%83%BD%E5%90%A6+-+%E6%9C%A8%E5%B0%8F%E9%9B%85.mp3&fn=%E5%8F%AF%E8%83%BD%E5%90%A6+-+%E6%9C%A8%E5%B0%8F%E9%9B%85.mp3&rtype=1&dp-logid=5769442373193499954&dp-callid=0.1.1&hps=1&tsl=80&csl=80&csign=2gwWVGVOXP%2FPhphqH%2BOnI6W79To%3D&so=0&ut=6&uter=4&serv=0&uc=3616567821&ti=76168191086d6f297102a53f8991dd0900ee6b2648095ca5&by=themis',
    title:'kenengfou'
  })
}
   else wx.playBackgroundAudio({
     dataUrl: 'https://bjbgp01.baidupcs.com/file/0f6eae85084f71ca934a5a167cf8baee?bkt=p3-000096447e650155069ae12351e92621fa6c&fid=4130625638-250528-202237789226690&time=1536206210&sign=FDTAXGERLQBHSKW-DCb740ccc5511e5e8fedcff06b081203-YIq9H1%2Bwc38%2BZvgj3xtzwYH%2FBaA%3D&to=75&size=9061562&sta_dx=9061562&sta_cs=4&sta_ft=wav&sta_ct=0&sta_mt=0&fm2=MH%2CYangquan%2CAnywhere%2C%2Chubei%2Cce&resv0=cdnback&resv1=0&vuk=4130625638&iv=0&htype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=000096447e650155069ae12351e92621fa6c&sl=76480590&expires=8h&rt=sh&r=661510257&mlogid=5763365579611275248&vbdid=57844512&fin=kma.wav&fn=kma.wav&rtype=1&dp-logid=5763365579611275248&dp-callid=0.1.1&hps=1&tsl=80&csl=80&csign=2gwWVGVOXP%2FPhphqH%2BOnI6W79To%3D&so=0&ut=6&uter=4&serv=0&uc=3616567821&ti=548236dbf16cf8fa29bc8bd859acf600d937e9e5ad0cba5d&by=themis',
      title: 'BGM'
     });
    
  }


})

