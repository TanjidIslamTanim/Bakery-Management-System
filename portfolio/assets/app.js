
(function(){
 const bar=document.querySelector('.progress'); const draw=()=>{let max=document.documentElement.scrollHeight-innerHeight;if(bar)bar.style.width=(max>0?scrollY/max*100:0)+'%'};addEventListener('scroll',draw,{passive:true});draw();
 const toggle=document.querySelector('.nav-toggle'),links=document.querySelector('.nav-links');if(toggle&&links){toggle.addEventListener('click',()=>{let open=links.classList.toggle('open');toggle.setAttribute('aria-expanded',String(open))});links.querySelectorAll('a').forEach(a=>a.addEventListener('click',()=>{links.classList.remove('open');toggle.setAttribute('aria-expanded','false')}))}
 const dialog=document.querySelector('.lightbox');if(dialog&&typeof dialog.showModal==='function'){document.querySelectorAll('[data-full]').forEach(btn=>btn.addEventListener('click',()=>{dialog.querySelector('img').src=btn.dataset.full;dialog.querySelector('img').alt=btn.dataset.alt;dialog.querySelector('[data-title]').textContent=btn.dataset.alt;dialog.showModal()}));dialog.querySelector('[data-close]').addEventListener('click',()=>dialog.close());dialog.addEventListener('click',e=>{if(e.target===dialog)dialog.close()})}
})();
