<?php get_header(); ?>

<div id="left-content-single">
		<?php if (have_posts()) : ?>
	
  		<?php while (have_posts()) : the_post(); ?>
<div class="post-home">
<div id="post-title-single"><h1><?php the_title(); ?></h1></div>
			<div class="post-content">
            	<div id="post-messages-single" class="clearfix"><span class="singlepost-meta"><?php the_tags('Tags:', ',', ' '); ?>  Posted in  <?php the_category(',') ?> <?php edit_post_link(__('&raquo;Edit'),'','.'); ?></span><span class="comments-popup-link"><a href="#comment"><?php comments_number('Leave a Comment', '1 Comment', '% Comments'); ?></a></span></div>
			<?php the_content(__('continue reading...')); ?>
           		<div class="post-time"><?php the_date(); ?></div>
           </div>           
</div>       
   <div id="copyright" >
   <p class="clearfix">
	
			<span style="float:left;"><?php previous_post_link('&laquo; %link') ?></span>
			<span style="float:right;"><?php next_post_link('%link &raquo;') ?></span>

   </p>
   
   </div>   
		
		<?php endwhile; else: ?>			
		<div id="featured-post">
			<h2><a href="<?php the_permalink() ?>">Not Found</a></h2>
			<p>Sorry, but you are looking for something that isn't here.</p>
		</div>		
		<?php endif; ?>

<div id="comment">
	<?php comments_template('', true); ?>
</div>
</div>
<?php get_sidebar(); ?>
<?php get_footer(); ?>