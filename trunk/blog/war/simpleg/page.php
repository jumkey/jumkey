

<?php get_header(); ?>


<div id="left-content-single">
  <?php if (have_posts()) : while (have_posts()) : the_post(); ?>
<div id="post-home">
<div id="post-content">
<div id="post-title-page"><h1><?php the_title(); ?></h1></div>
			<?php the_content('continue reading...'); ?>
			<?php link_pages('<p><strong>Pages:</strong> ', '</p>', 'number'); ?>
			</div>
    </div>
    
<div id="comment">
	<?php comments_template('', true); ?>

</div>
  <?php endwhile; endif; ?>
  </div><!--/content -->
	<?php get_sidebar(); ?>
<?php get_footer(); ?>