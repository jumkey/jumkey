<?php get_header(); ?>

<div id="postlist">
		<?php if (have_posts()) : ?>
	
  		<?php while (have_posts()) : the_post(); ?>
	<div id="post-<?php the_ID(); ?>" class="post-home">
    <div class="post-title"><h2><a href="<?php the_permalink() ?>" rel="bookmark"><?php the_title(); ?></a></h2><span class="post-time"><?php the_date(); ?></span></div>
			<div class="post-content"><?php the_content(__('continue reading...')); ?></div>
            <div class="post-messages"><p class="clearfix"><span class="indexpost-meta"><?php the_tags('Tags:', ',', ' '); ?>  Posted in  <?php the_category(',') ?></span><span class="comments-popup-link"><?php comments_popup_link('Leave a Comment', '1 Comment', '% Comments'); ?> </span></p></div>
    </div>       	
		
		<?php endwhile; else: ?>
			
		<div id="featured-post">
			<h2><a href="<?php the_permalink() ?>">Not Found</a></h2>
			<p>Sorry, but you are looking for something that isn't here.</p>
		</div>	
		
		<?php endif; ?>
		
<div class="navigation clearfix">
		<div class="alignleft"><?php next_posts_link(__('&laquo; Older Entries')) ?></div>
			<div class="alignright"><?php previous_posts_link(__('Newer Entries &raquo;')) ?></div>
		</div>





</div>
<?php get_sidebar(); ?>

<?php get_footer(); ?>