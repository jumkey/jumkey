</div></div>

<div id="foot">

<div id="mfoot"><a href="<?php bloginfo('url'); ?>/wp-login.php"><img style="display: inline; margin-left: 0px; margin-right: 0px" src="<?php bloginfo('template_directory'); ?>/images/login.png" align="left" alt="login" /></a>
<p style=" line-height:20px;">Powered by <a href="http://wordpress.org">wordpress</a>&nbsp;Theme by <a href="http://www.g9net.com">wlsy</a> Valid XHTML 1.0 </p>
<p style=" color:#494949"><?php printf(__('%d queries. %s seconds.', 'kubrick'), get_num_queries(), timer_stop(0, 3)); ?></p>
</div>
</div>
<?php wp_footer(); ?> 

</body>
</html>