<?php get_header(); ?>

<div id="left-content-single">
<div id="post-title-page">
<h1><?php _e('Search Results'); ?></h1>
</div>
		<?php if (have_posts()) : ?>
	
  		<?php while (have_posts()) : the_post(); ?>
<div class="post-home">
<div class="post-title"><h1><a href="<?php the_permalink() ?>" rel="bookmark"><?php the_title(); ?></a></h1></div>
			<div class="post-content">
            <div class="post-messages"><span class="post-msg"><?php the_tags('Tags:', ',', ' '); ?> 分类：<?php the_category(',') ?> Date：<?php the_time('Y/m/d'); ?></span><span class="post-comment"><a href="#comment"><?php comments_number('Leave a Comment', '1 Comment', '% Comments'); ?></a></span></div>
			<?php the_excerpt(); ?>


           </div>
         
    </div>       
 
            
            
      
          	

		<?php endwhile; ?>
<div class="navigation clearfix">
		<div class="alignleft"><?php next_posts_link(__('&laquo; Older Entries')) ?></div>
			<div class="alignright"><?php previous_posts_link(__('Newer Entries &raquo;')) ?></div>
		</div>

	<?php else : ?>

		<h2><?php _e('No posts found. Try a different search?'); ?></h2>
		<?php include (TEMPLATEPATH . '/searchform.php'); ?>

	<?php endif; ?>

</div>
<?php get_sidebar(); ?>
<?php get_footer(); ?>